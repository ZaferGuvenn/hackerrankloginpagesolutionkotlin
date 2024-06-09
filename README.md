# HackerRank Android Login Question in Kotlin

## Functionality Requirements:

Create a login screen, as shown above. Application requirements are given below, and the finished application must pass all of the unit tests.

Your task is to complete the implementation of MainActivity , ValidationUtils and activity_main.xml according to the following requirements:

The login screen contains one circular logo, one title, two inputs: username and password, and a login button. 




Design Specs:
* The background of rootview must be equal to _secondary_ color defined in colors.xml.
  Note: Use root layout background attribute.
* The logo must be a circular image of _hfwlogo.png_ in drawable folder with 100dp width, 100dp height, 100dp radius. 
  Note: Use _image_card_ view in xml to set the radius, width and height and use the _hfwlogo.png_ in drawable folder to set the image on _roundedImageView_ in xml.
* The white color _login_container_ that has the views: _title_, _username_, _password_, _login_btn_ must have height that wraps the content. The background must be extracted to a shape xml resource where the solid color and radius are defined. Solid color must be white. Top left and top right radius must be 30dp.

* _title_ :
  * Must wrap content for width and height, centered horizontally and 50dp below the top of _login_container_
  * The text must say "Login"
  + Text size must be 24sp, style must be bold, color must be _primary_ color defined in colors.xml.
* _username_ must wrap content for height and width must be given using ems attribute. The ems must be 15. It should have a hint -> "Username"
* _password_ must wrap content for height and width must be given using ems attribute. The ems must be 15.
* Clicking on Login Button should trigger the validation on the form.
* The Username input field is required. If the submit button is clicked and the username field is empty, the message Username is required should be rendered on the field. Else, no error message should be rendered.
* The Password input field is required. If the submit button is clicked and the password field is < 4 characters in length, the error Password must have minimum 4 characters should be rendered on the field. Else, no error message should be rendered.
* If both the inputs are valid, no error messages should be rendered and a toast must be displayed with the message "Success"
Initially, the files are filled with boilerplate code.


## Testing Requirements
Please note that the views in activity_main.xml has the id attributes for test cases to run correctly. It is advised not to change them.
