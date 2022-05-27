# VisitEase
This an android application that helps you recognize visitors/members and keep a track of their activity.

## Problem Statement:
### Face Recognition
Develop a browser-based application or a native mobile application to demonstrate application of Face Recognition technology.

You could choose to demonstrate application of Face Recognition in any area of application of your choice, for example:

* Preventing crime
* Device security
* Smarter advertising
* Finding mission people or lost pets
* Diagnose diseases
* Tracking attendance
* Facilitate secure transactions
You are free to choose any Face API you are comfortable with.

## My idea:
I visit a gym on a regular basis and I find the security guards and the employees having a hard time recognizing
the members, the staff gets transferred all the time from one branch of the gym to another. The gym members don't necessarily follow
a particular routine and they visit the gym at different times throughout the week, the staff at evening shift have a hard time recognizing
a member who usually visits the gym in the morning and vice-versa.
The biometric solution is very complex and costly, so I decided to build an android application that helps with verifying the members
and adding any additional details about them.
I decided to make the application in such a way that it can run on low end android phones too and without the use of internet to further reduce the cost.
I designed the UI in a very minimalistic way so that someone who's not very familiar with the technology can also use it effectively and we also know
that a security guard might not be very familiar with using such applications.

## What application of the Face Recognition technology am I demonstrating?
### I'm demonstrating:
* Preventing crime -> Biometric Verification using the person's Face.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites:
The things you need ready before installing the software.
* [Android Studio](https://developer.android.com/studio/intro) / [Watch Tutorial](https://www.youtube.com/watch?v=5LMRbAiRkdY)

### Installation:
Clone this repository and import into **Android Studio**
```bash
git clone https://github.com/farazxsiddiqui/VisitEase.git
```

### Permissions:
First enable these permissions manually from the app info in device settings if not prompted.
* Camera

## Tech-Stacks/Libraries/APIs/Models used:
* Java
* [Tensorflow Lite](https://www.tensorflow.org/lite/android) / [Watch Tutorial](https://www.youtube.com/watch?v=s_XOVkjXQbU&t=874s)
* [SQLite](https://www.sqlite.org/docs.html) / [Watch Tutorial](https://www.youtube.com/playlist?list=PLSrm9z4zp4mGK0g_0_jxYGgg3os9tqRUQ)
* [CameraX](https://developer.android.com/training/camerax) / [Watch Tutorial](https://www.youtube.com/watch?v=IrwhjDtpIU0&t=1s)

## Face Recognition Model: 
MobileFaceNet:
* [Research Paper](https://drive.google.com/file/d/1rrdEO7VSBviZQSjvADM74SjCz-m4r-6c/view?usp=sharing)
* [Implementation](https://github.com/sirius-ai/MobileFaceNet_TF)

## GitHub Resources:'
* [CameraX-In-Java](https://github.com/Faisal-FS/CameraX-In-Java) by [Faisal-FS](https://github.com/Faisal-FS)
* [Real-Time_Face_Recognition_Android](https://github.com/atharvakale31/Real-Time_Face_Recognition_Android) by [atharvakale31](https://github.com/atharvakale31)


## Features:
* Add a new visitor by clicking on the "Add Visitor" button, you should see a preview of the face and an "Add Face" button to the right of it.
  Click on the "Add Face" and then enter the name of the visitor to store his/her data.
* Click on the options button near bottom-right corner to see a list of available actions.
* Save the data so that the face data gets stored in the local storage.
* Alternatively you can click on "Import Photo" in the Actions menu to import a photo directly from your local storage.
* Now point the camera at the visitor and the name of the visitor should pop up, you can flip the camera using the "Flip Camera" button.
  Now if there are a lot of visitors and you are in a hurry you can click on the "Speak" button on the left side of the "Add Visitor" button
  it will then speak the name of the visitor and you would not have to look into the screen all the time and if the person is not a visitor
  it would speak "Unknown" and if you have not held the device properly and it is unable to detect the face it would speak "No Face Detected!"
* You can see the list of visitors in the "View Visitors List" in the Actions menu to see the list of visitors.
* You can click on any name and you would be redirected to a new activity where you can select the name of a visitor
  and get the details of that particular visitor only.
* You can click on "Update Visitors List" to delete a particular visitor's face data, you can select multiple visitors too.
  Deleting a visitor's face data also deletes his activity details.
* You can click on "Clear Data" option in the Actions menu to delete the face data and the details of all visitors.
* You can click on "View Entries" option to view the details of all visitors in the order of their arrival.
* After clicking on "View Entries" you would be redirected to a new activity where you can see the details of all visitors
  and you would find an "Add Detail" button near the botton-right corner, you can click on that to 
  add/modify/delete a particular visitor's activity details.
* You also can click on "Modify Entries" option in the Actions menu to add/modify/delete a particular visitor's activity details.

## Future scope of VisitEase:
* I would like to continue working on the application and make it much better than it is today. 
* I want to provide an easy biometric security solution to small businesses and firms who cannot afford a proper functioning biometric verification system.
* More than 55% of Indians don't have access to the internet and I want to make this application be available to them without needing the internet to run it.
* In India the crime rates are extremely high in some cities and through this application I am aspiring to change it.
* We all know the importance of a woman's safety in today's world, if something like "VisitEase" is implemented on all private buildings/firms,
  an imposter would never be able to access these private spaces and only an authorized person would be allowed.
* All this could be done with a free application like "VisitEase". 
* I wish to make an impact and bring a change in our society through this application.

## Application file:
[VisitEase](https://drive.google.com/file/d/1YP06oNYp7tlw03Rdli-qqDtU0eQ96C3H/view?usp=sharing) / I'm also planning to deploy the application on Google Play Store so that everyone can access it.
