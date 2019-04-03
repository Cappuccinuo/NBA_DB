/* global app */
/* global angular */
/*global $rootScope*/

app.controller('booksCtrl', ['$scope', '$state', '$stateParams', 'bookService', 'authorService', 'enableEditService', 'uiGridConstants', function($scope, $http, $state, $stateParams, bookService, authorService, enableEditService, uiGridConstants, $index) {
  
  $scope.include = function(obj) {
     bookService.updateBooks(obj);
   };
   
  $scope.authorNameDropdown = authorService.authorsList; 
  $scope.bookData = bookService.booksList;
  


  //genre options for the table
  $scope.genreTypes = [
    {id:"Murder Mystery", value:"Murder Mystery"},
    {id:"Historical Fiction", value:"Historical Fiction"},
    {id:"Contemporary Fiction", value:"Contemporary Fiction"} 
  ];
  //genre dropdown options for the modal
  $scope.genreTypesModal = [
    "Murder Mystery", "Historical Fiction", "Contemporary Fiction" 
  ];
  
  //changes depending on who is logged in, allows cells to be edited via cellEditableCondition in columnDefs
  $scope.edit = enableEditService.edit;
  
  //set up for the book grid
  $scope.bookGridOptions = {
    
    data: 'bookData',
    enableCellSelection: true,
    enableCellEdit: true,
    enableCellEditOnFocus: true,
    enableColumnMenus: false,
    enableSorting: false,
    rowEditWaitInterval: -1, //stops default save behavior
    saveFocus: false,
    saveScroll: true,
    saveGroupingExpandedStates: true,
    enableRowSelection: true,
    onRegisterApi: function (gridApi) {
                   $scope.gridApi = gridApi;
                   $scope.gridApi.edit.on.afterCellEdit($scope,function(rowEntity, colDef, newValue, oldValue){
                         if(newValue != oldValue){
                            $state.reload();
                         }
                    });
                   },
  
    columnDefs: [

       { field: 'id', displayName: 'ID', enableCellEdit: false, enableHiding: false
       },
       { field: 'name', displayName: 'Name', enableHiding: false, cellEditableCondition: $scope.edit
       },
       { field: 'author', displayName: 'Author', enableHiding: false, cellEditableCondition: $scope.edit,
         cellTemplate: 'tempAuthor.html', 
         editableCellTemplate: 'ui-grid/dropdownEditor',
         editDropdownOptionsArray: authorService.authorsList,
         editDropdownIdLabel: 'id',
         editDropdownValueLabel: 'name' 
       },
       { field: 'genre', name: 'genre', displayName: 'Genre', enableHiding: false, cellEditableCondition: $scope.edit,
         editableCellTemplate: 'ui-grid/dropdownEditor',
         editDropdownOptionsArray: $scope.genreTypes
       },
       { field: 'dateAdded', displayName: 'Date Added', enableCellEdit: false, enableHiding: false
       },
       { field: 'outOfPrint', displayName: 'Out of Print?', enableCellEdit: false, enableHiding: false
       },
    ]
  };
  
//map will loop through all the books objects in bookData
$scope.bookAuthorNames = $scope.bookData.map(function(book){
    //create a variable to store author id of each book in bookData
     var bookAuthorId = book.author; 
     
     //var authorName is a variable to store the result of the following filter
     //filter will look through each object of the authorsList array and return the one that has
     //the object's author id equal to the author id of the books in bookData
     $scope.authorName = authorService.authorsList.filter(function(author){
        return author.id == bookAuthorId; 
        //it will return an array of one object from authorsList that matches the criteria but to access that object,
        //you have to choose index [0] because it's the only one in the array
        //then you specify that you want the author name from that same object
    })[0].name;
    //returns the name for the author (in a string) that belongs to that id
    return $scope.authorName;
 });
 //.map will continue to filter and compare through rach book object in bookData and always return the name of the
 //author that corresponds with that id - bookAuthorsNames holds the data, so this is a new array of just the author names

var today = new Date();
var date = (today.getMonth()+1)+'/'+today.getDate()+'/'+today.getFullYear();

  //when user clicks save in the new book modal, adds the inputs to the book array
  $scope.addNewBook = function() {
     var n = $scope.bookData.length + 1;
     $scope.bookData.push( { id: n, name: $scope.newTitle, author: $scope.newAuthor, genre: $scope.newGenre, dateAdded: date, outOfPrint: "No" });
     $state.reload();
     $scope.closeModal();
     event.preventDefault();
     };

  //when user selects a book and clicks delete
  $scope.deleteSelected = function(row) {
    angular.forEach($scope.gridApi.selection.getSelectedRows(), function (data, index) {
    $scope.bookData.splice($scope.bookData.lastIndexOf(data), 1);
  });
};

//get modal
var modal = angular.element( document.querySelector( '#bookModalBody' ) );

//open the modal
$scope.openModal = function() {
    modal.css('display', 'block');
};

//clicking cancel once modal is open, or closing the modal after saving
$scope.closeModal = function() {
    modal.css('display', 'none');
};

}]);
