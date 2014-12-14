set terminal png
set xlabel "Time since start"
set ylabel "CREATE ops per second"
set size 1.0, 0.6
set output "create.png"
plot "CREATE.dat" with lines
set term pop

set terminal png
set xlabel "Time since start"
set ylabel "DELETE ops per second"
set size 1.0, 0.6
set output "delete.png"
plot "DELETE.dat" with lines
set term pop

set terminal png
set xlabel "Time since start"
set ylabel "READ ops per second"
set size 1.0, 0.6
set output "read.png"
plot "READ.dat" with lines
set term pop

set terminal png
set xlabel "Time since start"
set ylabel "SETMULTI ops per second"
set size 1.0, 0.6
set output "setmulti.png"
plot "SETMULTI.dat" with lines
set term pop


set terminal png
set xlabel "Time since start"
set ylabel "SETSINGLE ops per second"
set size 1.0, 0.6
set output "setsingle.png"
plot "SETSINGLE.dat" with lines
set term pop