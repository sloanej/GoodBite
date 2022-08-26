# GoodBite

## Project Description
GoodBite is a web application developed by Jack Sloane, Ishaan Gulati, and Neha Surana for a graduate level Software Engineering Course at Virginia Tech.

## Project Objective
The objective of our team project is to demonstrate how capable the team members are in engineering a Jakarta/Java EE cloud software application to solve a complex problem. The cloud software application is created for the purpose of showing how learned and new complex functionalities and features the team members are capable of developing. 

## List of Implemented Cloud Software Features Learned
1.	Create, Read, Update, Delete (CRUD) operations in a MySQL database.
2.	Template-based User Interface (UI) with header and footer implementation.
3.	Use of JPA to interact with MySQL.
4.	Obtain JSON from an API and process JSON data.
5.	Use PrimeFaces content flow to display images on the homepage.
6.	User login flow, reset password flow, and sign up flow.
7.	Create cloud storage for the user to upload/download files.
8.	The use of Datatable, Datagrid and Datalist for displaying data.
9.	Responsive Dialogues with Scrollable contents
10.	TextBox Scrollable Vertically
11.	Database search for geocodings
12.	Custom CSS sheets

## Delivered Software Functionallity
Due to hosting costs, we the website for GoodBite is no longer live. Here is a detailed walk-through of our software functionality. We start at the home page of our application website: 

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985459-41335bf3-287e-4600-9ed7-7f273135fe6a.png">
Fig. 1 

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985616-16b1737d-a2ba-470f-9a29-4a44f7350d0a.png">
Fig. 2:  The home page (Fig. 12&13) displays a galleria of nutrition fact images and a carousel of meals from the recipes database with associated nutrition information. 

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985717-0b99bd99-e201-452e-81b7-4715ac3ae2e3.png">
Fig. 3: The About Us page shows a description of the team members of the project.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985734-39506875-4b27-4839-8527-abc42dbeddb6.png"> 
Fig. 4: The sign in page allows the user to sign in using a username and password.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985754-b12286cc-7b96-48aa-aa6d-35f79ce43341.png"> 
Fig. 5: The navigation dropdown menu in the header lists links to different pages. When not signed in, the dropdown menu lists the Home page, the About Us page, the Shared Meals page, the Sign In page, and the Create Account page. 

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985766-7797dbbf-bdca-4fe2-9f05-a895ede3e0d6.png"> 
Fig. 6: The create account screen mirrors has standard functionality.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985790-4eb8cb6c-436d-4480-9960-6d4f81e35641.png">
Fig. 7: When an account is created, the user is redirected to the Sign-In page. 
 
<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985811-1be21678-7278-43fc-abc8-261a1f8fc367.png">
Fig. 8: If the user enters invalid credentials into the username and/or password field of the Sign-In page, an appropriate error message is displayed.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985864-f66a0dd5-ad5c-4f86-837a-474b71dea68e.png">
Fig. 9: The Profile page allows the signed in user to view and edit their account information. Additionally, the user can navigate to the My Uploaded Meals page from the Profile page. When the user is signed in, the navigation dropdown menu in the header is changed, allowing the user to access more pages and dialogs. Now, the user can additionally access the My Uploaded Meals page, the Nearby Store search dialog, the Search Recipe dialog, the My Pantry page, the Saved Recipe page, and the Sign Out button.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985883-1af7178f-47b4-43f4-ba43-273977425247.png">
Fig. 10: The Uploaded Meals page is where the user can upload pictures and descriptions of meals they made. The user presses the Upload Meal button and is redirected to the Upload Meal page.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985899-2407b3a8-5d93-4182-809d-16c006c81c1f.png"> 
Fig. 11: In the Upload Meal page, the user selects an image file to select from their local files and enters a meal name and description. All three fields are required, and only image files are accepted.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985916-dde7c3e1-a610-4850-820e-59f680297861.png">
Fig. 12: If all the fields are satisfied and the user presses submit, the file is uploaded, and a success message is displayed.
 
<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985944-9d274a09-60a1-4d2b-85d3-fb79bfab33c0.png">
Fig. 13: The user can now view the uploaded Meal in the Uploaded Meals page. Each meal is displayed in a card with a delete and share button attached.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985961-e7dcc3b0-1770-4b97-83a6-69b77a8b266a.png"> 
Fig. 14: Clicking the share button prompts the user to enter a name to be publicly displayed with the meal in the Shared Meals page. This field is required.
 
<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985980-b516f36a-c21f-471b-946d-7de9986190d1.png">
Fig. 15: Upon entering the public name and clicking share, a success message is displayed if the file was successfully shared.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186985998-2161bf24-20ff-4665-b9ed-2d3e0e981ea9.png">
Fig. 16: The delete button causes a confirmation prompt to be displayed, wherein the user can confirm or cancel the deletion of the uploaded meal.
 
<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986019-7776c63d-eb37-4af4-baec-4f537ecca0a5.png">
Fig. 17: The Shared Meals page displays the shared meals of all users and their associated names. Each meal card on this page has a “remove meal” button, but the button is greyed out unless it’s attached to a meal that was uploaded by the same user that is currently signed in.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986035-985c5c1e-4f1c-433b-a0ce-e9758c54e3e1.png">
Fig. 18: The Search Nearby Stores dialog prompts the user for a zip code, a distance radius, and the number of desired results. All three fields are required. The dialog includes a button to cancel which closes the dialog, a button to clear the contents of the dialog, and a button to search.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986046-304c7dd7-ab07-4f9b-a96e-cba5c0b68c7b.png">
Fig. 19: Clicking the search button in the previous dialog redirects the user to the Nearby Store Results page. This page displays all nearby grocery stores, obeying the parameters the user selected in the search dialog. Each item in this results page includes the name of the store, the address, and the distance.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986067-e8654e13-fd3c-4710-a8da-25101542f9ce.png">
Fig. 20: The Nearby Store Results page can be toggled to display in grid or list format.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986120-881199d7-50f4-48d0-9de9-c19244919d2d.png">
Fig. 21: The Search Recipes dialog prompts the user to enter a search string, which queries the recipes API for relevant recipes. Once pressing the search button, the user is redirected to the API Search Results page  

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986155-76ce423d-b404-4322-a61d-a3e439339546.png"
Fig. 22

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986180-dfb2e7a6-643d-4323-92f7-af2cd836df2c.png">
Fig. 23

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986195-283f6100-225b-4b20-9b5a-6f421fb58659.png">
Fig. 24: The API Search Results pages (Fig. 22,23,24) displays relevant recipes with a recipe name and author displayed in each card. Pressing the information icon, will display detailed information about the recipe, including the ingredients, health labels, diet labels, nutrition information, calories, and a link to cooking directions. From here, the user can save the recipe to the Saved Recipes page. 

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986282-8fb4f9c8-5cfc-418f-8d83-2334703682c0.png"> 
Fig. 25: Upon clicking save, a status message will appear informing the user if the recipe was successfully saved or not.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986308-45a66e21-2b75-4d72-bcac-9b141d98ac72.png">
Fig. 26: The Virtual Pantry page is where the user can add their owned ingredients to the database in order to easily search for possible recipes. The page includes a button to add an ingredient to the pantry, update a pantry ingredient, delete an ingredient, or search recipes from pantry ingredients.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986320-072a8a3e-aed2-4645-ba31-0e3b26e4a2a0.png">
Fig. 27

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986338-e65a3604-6363-491b-8ae0-89a9d5778c87.png">
Fig. 28: The “add to pantry” button displays a dialog in which the user enters the ingredient name, quantity, and unit of measurement. 

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986349-c8d17d03-9587-4ab2-8301-e25bb1d7c2b5.png"> 
Fig. 29: Clicking save will add the ingredient to the virtual pantry list. The nutrition and calorie information are automatically filled in via a query to the nutrients API.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986371-5b7b985e-6940-411f-99fb-ab96343718ee.png">
Fig. 30: The “update pantry” and “delete from pantry” button are only functional if an ingredient is selected from the table. The “update pantry” button allows the user to adjust a selected ingredient's name, quantity, and unit.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986394-a50b368c-4c9c-4f90-abab-39aba295cebf.png">
Fig. 31

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986413-51cd2d51-004b-4681-ad19-db2f9be075a3.png">
Fig. 32: Selecting an ingredient and clicking the “delete from pantry” button displays a confirmation dialog (Fig. 42) where the user can confirm or cancel the deletion. If confirmed, a status message will be displayed if the deletion succeeded or failed.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986441-87e2b0f1-5253-4abe-92fb-9646c2b46f09.png"> 
Fig. 33
 
<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986463-eeb71ace-54f8-469d-972b-836511217e04.png">
Fig. 34: Clicking the “search recipes from pantry ingredients” button displays a dialog with a dropdown menu containing the ingredients in the virtual pantry. Individual ingredients can be selected from the dropdown, or the top box can be checked to select all ingredients. Pressing search will query the recipes API using the selected ingredients and redirect the user to the Recipe Results page.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986497-831be85a-79d3-48b8-b30c-c2315a3ee53f.png">
Fig. 35: The user can update their account information.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986537-7edc3573-eb81-4ebe-830f-18e65865a820.png">
Fig. 36: The user can change their profile photo by either taking a picture with their webcam or uploading an image file. Since our application uses HTTPS, the webcam functionality works even in the deployed application.

<img width="470" alt="image" src="https://user-images.githubusercontent.com/46733794/186986566-4ecb943b-9711-42a3-8e75-b3ae81791c8e.png">
Fig. 37: Upon clicking the upload button, a status message is displayed informing the user whether the profile photo was successfully uploaded and changed.



