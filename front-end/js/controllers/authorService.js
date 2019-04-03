/*global app*/
/*global $scope*/

app.service('authorService', function ($http) {

var authorsList = [
  {
    id: 1, 
    name: "Ian McEwan", 
    age: 42
  },
  {
    id: 2, 
    name: "Charles Dickens", 
    age: 105
  },
  {
    id: 3, 
    name: "Arthur Conan Doyle", 
    age: 125
  },
  {
    id: 4, 
    name: "Agatha Christie", 
    age: 98
  }
];

function updateAuthors (newObj) {
    
    authorsList.push(newObj);
    console.log(authorsList);
    
}
  
return {
    
    authorsList : authorsList,
    updateAuthors : updateAuthors 
    
};

});