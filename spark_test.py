#!/Users/marwamostsafa/opt/anaconda3/bin
import sys

n_lines = 0
for line in sys.stdin.readlines():
    sys.stdout.write(line.upper())
    n_lines += 1

sys.stdout.write(str(n_lines))
sys.stdout.flush()

