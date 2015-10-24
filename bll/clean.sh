echo "Cleaning up ..."
compilationDirectory=$1

rm sources.txt generated-sources.txt
rm -rf $compilationDirectory
