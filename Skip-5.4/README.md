Skip-5.4
========

The following project contains the code necessary to build Skip-5.4, team 3467's 2014 robot.

In order to build and deploy code:

1. Install eclipse on your development machine
   If this is not already installed, download "Eclipse IDE for Java" from:
      https://www.eclipse.org/downloads/

2. Launch eclipse

3. Install eGit
   eGit is an eclipse plugin that allows you to access the GIT repository where team 3467 code is stored.
   To install eGit, navigate to the Help Menu from Eclipse (top of screen), then select "Eclipse MarketPlace" from 
   the menu.
   In the "Find" textbox, type "eGit", then click on the magnifier to search for the eGit installer.
   After some time, eclipse should present you with a list. Select "eGit - Egit Team Provider" from the list and 
   select the "install" button for this.
   (If the "install" button is not present, eGit is already installed and you can skip this step)

4. Import robotics code
   Right click within the white space in Package Explorer (the eclipse package explorer is the window pane on the 
   left, by default).
   From the context menu, select "Import..."
   Now Select Git -> Projects from Git.
   Click next.

   This will prompt you for the location of the GIT projects you want to import. Specify Clone URI to copy files 
   from GITHUB.
   Click next.

   When prompted for a location URI, specify: https://github.com/FRCTeam3467/Robotics.git
   Click next.
   NOTE: As source code is public, you do not need to specify a GITHUB user/password. If you want to commit changes 
   (i.e. modify the project in GITHUB), you will need to specify credentials. This is something we will cover 
   subsequently.

   Next, you will be prompted to specify a branch. 
   The master branch will suffice for now.
   Click next.

   You will be prompted to specify a local directory to which the GITHUB files should be copied. The default should
   be fine (I used a local folder "c:\users\cartral\git\robotics"). Click next.

   You will be prompted as to how remote directories should be processed. Make sure "Import existing projects" is 
   specified and click next.

   All the code should now be available on your machine.
   
5. Make sure that the default Java JRE contains a compiler.
   There are different java builds.
   A Java JRE contains a java runtime only. It can run pre-compiled java code (i.e. classes), but cannot build java 
   source code.
   A Java JDK (sometimes known as a java SDK) contains a java compiler and a java runtime. It can run pre-compiled 
   java code (i.e. classes) and can 
   also compile java code.
   The Robotics code uses ANT as its build system. This requires a Java SDK to compile your project.
   In order to configure eclipse, make sure you have first installed a java 1.7 SDK. You can download this from:
     http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
   
   Install the java 1.7 SDK and make a note of the directory where you install it.

   Once you have a Java 1.7 SDK installed locally, navigate to the Window menu, then select preferences.
   Now select Java->Installed JREs from the window pane on the left.
   
   This will bring up an editor on the right that allows you to specify which java compilers are known to the system and
   which are default.
   Click on the add button.
   Specify Standard VM and click next.
   
   In the jre home text box, specify the directory where you installed java, e.g. "c:\development tools\Java1.7".
   In the jre name text box, specify "Java 1.7"
   Then click Finish.
   
   Now, on the Installed JREs, click on the check box next to "Java 1.7" to make it the default. Click Ok.
   
6. Create a short cut to allow the Skip-5.4 project to be built.
   Expand the Skip-5.4 project from the package explorer.
   Select build.xml, now right click and specify "Run as" and "External Tools Configurations".
   Double click on "Ant build" on the left ant pane.
   
   On the top above the right pane, specify a name "Build and deploy Skip-5.4"
   Click on the targets tab in the right pane.
   Now click on the "jar-app" and "deploy" check boxes to select these.
   The text box on the bottom should show "jar-app, deploy".
   Click Run.
   If prompted to save this, click Ok.
   
7. To rebuild/redeploy Skip-5.4
   Select run from the menu bar, then External Tools -> Build and deploy Skip-5.4"
   