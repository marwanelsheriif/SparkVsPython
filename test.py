import time
import subprocess

start_time_ms = time.time()
start_time_ns = time.time_ns()
with open('SparkSimpleApp/oneString10.txt', 'r') as file:
    data = file.read()
    data = ''.join(data)


out_file = open('stdout.log', "w")
err_file = open('stderr.log', "w")
p1 = subprocess.Popen(["/Users/marwamostsafa/opt/anaconda3/bin/python", "spark_test.py"], stdin=subprocess.PIPE, stdout=out_file, stderr=err_file)


stdout_data_1 = p1.communicate(input=data.encode())[0]


print("waiting...")

out_file.close()
err_file.close()
print("End time in s: ", time.time() - start_time_ms)
print("End time in ns: ", time.time_ns() - start_time_ns)
