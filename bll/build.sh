echo "Cleaning up ..."
rm sources.txt generated-sources.txt
rm -rf compiled
mkdir compiled

echo
echo "Creating POC_BLL env variable ..."
export POC_BLL=$(pwd)
echo "Created POC_BLL='"$POC_BLL"'"

echo "Adding POC_BLL to PATH env variable"
export PATH=$PATH:$POC_BLL

echo "Creaing POC_BLL_COMPILED env variable ..."
export POC_BLL_COMPILED=$POC_BLL"/compiled"

echo
echo "Creating a ist of souce files ..."
find src -type f -name "*.java" > sources.txt

echo "Creating a list of generated source files ..."
find target/test-classes -type f -name "*.java" > generated-sources.txt

echo
echo "Compiling bll/src and dependencies ..."
javac @sources.txt @generated-sources.txt -d compiled -cp "./target/sources/*"
# javac @sources.txt @generated-sources.txt -d compiled -cp "target/sources/gson-2.3.1-sources.jar:target/sources/junit-4.12-sources.jar:target/sources/hamcrest-core-1.3-sources.jar:target/sources/dagger-2.0-sources.jar:target/sources/javax.inject-1-sources.jar"
# javac @sources.txt @generated-sources.txt -d compiled -cp "$POC_BLL_COMPILED/gson-2.3.1-sources.jar:$POC_BLL_COMPILED/junit-4.12-sources.jar:$POC_BLL_COMPILED/hamcrest-core-1.3-sources.jar:$POC_BLL_COMPILED/dagger-2.0-sources.jar:$POC_BLL_COMPILED/javax.inject-1-sources.jar"

echo
echo "Running tests ..."
java -cp "$POC_BLL_COMPILED:junit-4.12.jar" org.junit.runner.JUnitCore org.shiftedapps.helloworld.bll.MessagesIntegrationTest


