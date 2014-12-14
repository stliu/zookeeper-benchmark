package edu.brown.cs.zkbenchmark;

import com.netflix.curator.framework.CuratorFramework;
import com.netflix.curator.framework.api.CuratorEvent;
import com.netflix.curator.framework.api.CuratorEventType;
import com.netflix.curator.framework.api.CuratorListener;

import edu.brown.cs.zkbenchmark.ZooKeeperBenchmark.TestType;

class BenchmarkListener implements CuratorListener {
    private final BenchmarkClient _client; // client listener listens for

    BenchmarkListener(BenchmarkClient client) {
        _client = client;
    }

    @Override
    public void eventReceived(CuratorFramework client, CuratorEvent event) {
        CuratorEventType type = event.getType();
        TestType testType = _client.getBenchmark().getCurrentTest();
        // Ensure that the event is reply to current test
        if ((type == CuratorEventType.GET_DATA && testType == TestType.READ) ||
                (type == CuratorEventType.SET_DATA && testType == TestType.SETMULTI) ||
                (type == CuratorEventType.SET_DATA && testType == TestType.SETSINGLE) ||
                (type == CuratorEventType.DELETE && testType == TestType.DELETE) ||
                (type == CuratorEventType.CREATE && testType == TestType.CREATE)) {
            _client.getBenchmark().incrementFinished();
            _client.recordEvent(event);
            _client.resubmit(1);
        }
    }
}
