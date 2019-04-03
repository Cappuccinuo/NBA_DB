/*global app*/
app.service('bookService', function ($http) {
    
    var booksList = [
  {
      id: 1, 
      name: "Hound of the Baskervilles", 
      author: 3, 
      genre: "Murder Mystery", 
      dateAdded: "1/18/2015", 
      outOfPrint: "No",
      active: true
  },
  {
      id: 2, 
      name: "The Scowrers", 
      author: 3, 
      genre: "Murder Mystery", 
      dateAdded: "1/1/2016" , 
      outOfPrint: "Yes",
      active: true
  },
  {
      id: 3, 
      name: "Amsterdam", 
      author: 1, 
      genre: "Contemporary Fiction", 
      dateAdded: "2/28/2015" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 4, 
      name: "Saturday", 
      author: 1, 
      genre: "Contemporary Fiction", 
      dateAdded: "2/9/2015" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 5, 
      name: "The Comfort of Strangers", 
      author: 1, 
      genre: "Contemporary Fiction", 
      dateAdded: "4/15/2016" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 6, 
      name: "Chesil Beach", 
      author: 1, 
      genre: "Contemporary Fiction", 
      dateAdded: "6/22/2015" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 7, 
      name: "Atonement", 
      author: 1, 
      genre: "Historical Fiction", 
      dateAdded: "1/17/2016" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 8, 
      name: "Bleak House", 
      author: 2, 
      genre: "Historical Fiction", 
      dateAdded: "12/13/2015" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 9, 
      name: "Oliver Twist", 
      author: 2, 
      genre: "Historical Fiction", 
      dateAdded: "4/11/2016" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 10, 
      name: "Nicholas Nickleby", 
      author: 2, 
      genre: "Historical Fiction", 
      dateAdded: "5/17/2016" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 11, 
      name: "David Copperfield", 
      author: 2, 
      genre: "Historical Fiction", 
      dateAdded: "1/9/2015" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 12, 
      name: "The Pickwick Papers", 
      author: 2, 
      genre: "Historical Fiction", 
      dateAdded: "8/1/2015" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 13, 
      name: "Death on the Nile", 
      author: 4, 
      genre: "Murder Mystery", 
      dateAdded: "6/2/2016" , 
      outOfPrint: "No",
      active: true
  },
  {
      id: 14, 
      name: "Betrams Hotel", 
      author: 4, 
      genre: "Murder Mystery", 
      dateAdded: "5/11/2015" , 
      outOfPrint: "No",
      active: true
  }
];

function updateBooks (newObj) {
    
    booksList.push(newObj);
    console.log(booksList);
    
}
  
return {
    
    booksList : booksList,
    updateBooks : updateBooks    
};
    
});