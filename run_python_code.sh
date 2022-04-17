

PATH+=:/Users/marwamostsafa/opt/anaconda3/bin # run 'which python' and add the path here to avoid 'python: command not found'
parent_path=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P ) # This is to make the python script work independent of where you invoke it from.

cd "$parent_path"

read -r line

echo "$line" | python spark_test.py
