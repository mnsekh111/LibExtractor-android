# LibExtractor-android
Shared Library extractor for Android apk files

Done for Bluestacks Hiring Challenge

# How to run
1.  Clone the project to the local system

2.  Go to the "src" folder in the project and type this 
    javac -d ../out/production/LibExtractor/ *.java
    
    You can specify any output folder. (I'm using the convention followed by intellij)

3. Now enter cd ../out/production/LibExtractor/ 
    You should be in out/production/LibExtractor/  

4. Run LibExtractor.class using java LibExtractor <absolute-location0of-apk>

# Screen shots
![ScreenShot](https://raw.githubusercontent.com/mnsekh111/LibExtractor-android/master/screenshots/Screenshot%20from%202015-12-19%2015%3A43%3A32.png)

![ScreenShot](https://raw.githubusercontent.com/mnsekh111/LibExtractor-android/master/screenshots/Screenshot%20from%202015-12-19%2015%3A43%3A51.png)


In LibInfo file you can add methods to extract specific properties. Currently the app displays all the properties related to the shared file"
![ScreenShot](https://raw.githubusercontent.com/mnsekh111/LibExtractor-android/master/screenshots/Screenshot%20from%202015-12-19%2015%3A44%3A34.png)


5. While running please uncomment deleteDirectory(myTempDir); in traverseZip() in UnzipUtility.java


# View extracted .so files
 Please refer to temp firectory within the project
 
