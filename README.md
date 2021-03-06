# RecipeProject
It is a spring boot application , in which CRUD operations will be done using Rest Api's for Recipes..
  
  Here are the sample screenshots are placing to access the data..

-  For getting all the recipe details from the table
-    url : http://localhost:9118/recipes
-     method : GET

![image](https://user-images.githubusercontent.com/74124907/130565446-b0899ff3-fc65-4176-b926-0bc8243816c2.png)

- For getting single record of recipe with its id
-    url : http://localhost:9118/recipe/54
-     method : GET

![image](https://user-images.githubusercontent.com/74124907/130565669-1961546a-d4a8-4475-9367-2351483fba96.png)

- For inserting recipe details
-    url : http://localhost:9118/recipe
-      method : POST
-    input  : 
```
{
        
        "recipeName": "burger",
        "recipeType": "veg",
        "noOfPeople": 2,
        "instructions": "1.take flour,2.add water and veggies,3.bake it",
        "ingredients": [
            {
          
                "name": "wheat flour"
            },
            {
            
                "name": "veggies"
            }
        ]
    }
```

![image](https://user-images.githubusercontent.com/74124907/130565963-fb885565-8811-424f-a196-96a9e40cc256.png)

- For Updating recipe details
 -    url : http://localhost:9118/recipe/55
 -      method : PUT
  -    input :
```
{
    "recipeName": "burger",
    "recipeType": "nonveg",
    "noOfPeople": 1,
    "instructions": "1.take flour,2.add veggies and chicken,3.cook it",
    "ingredients": [
        {
            "ingId": 96,
            "name": "rice"
        },
        {
            "ingId": 97,
            "name": "dal"
        }
    ]
}
```

![image](https://user-images.githubusercontent.com/74124907/130566178-b36e7bc6-9a2f-4b48-a175-9adeffcaffe0.png)

- For deleting the recipe with id
 -    url : http://localhost:9118/recipe/54
 -      method  : DELETE

![image](https://user-images.githubusercontent.com/74124907/130566314-6f99a456-c5dd-48b9-a825-5e9fda423833.png)

## Swagger Documentation Details::
- For more information about the API's , Swagger document is generated..,below is the url to access Swagger documentation
    
-    url for Swagger docs : http://localhost:9118/swagger-ui.html

### API Authentication Details::

- Added basic authentication for the APi's 
 -   userName : recipe
 -   password : password
    
    
