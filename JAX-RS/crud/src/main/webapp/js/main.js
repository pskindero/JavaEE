// The root URL for the RESTful service
var rootURL = "http://localhost:8080/crud/shop/books";


var currentBook;

findAll();
$('#btnDelete').hide();


$('#btnSearch').click(function() {
	console.log('btnSearch clicked');
	search($('#searchKey').val());
	return false;
});

$('#searchKey').keypress(function(e){
	if(e.which == 13) {
		search($('#searchKey').val());
		e.preventDefault();
		return false;
    }
});

$('#btnAdd').click(function() {
	newBook();
	return false;
});

$('#btnSave').click(function() {
	if ($('#bookId').val() == '')
		addBook();
	else
		updateBook();
	return false;
});

$('#btnDelete').click(function() {
	deleteBook();
	return false;
});

$('#bookList a').live('click', function() {
	findById($(this).data('identity'));
});

function search(searchKey) {
	console.log('searchKey with values: ' + searchKey);
	if (searchKey == '') 
		findAll();
	else
		findById(searchKey);
}

function newBook() {
	$('#btnDelete').hide();
	currentBook = {};
	renderDetails(currentBook); 
}

function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", 
		success: renderList
	});
}

function findById(id) {
	console.log('findById: ' + id);
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + id,
		dataType: "json",
		success: function(data){
			$('#btnDelete').show();
			console.log('findById success: ' + data);
			currentBook = data;
			renderDetails(currentBook);
		}
	});
}

function addBook() {
	console.log('addBook');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Book created successfully');
			$('#btnDelete').show();
			$('#wineId').val(data.id);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addBook error: ' + textStatus);
		}
	});
}

function updateBook() {
	console.log('updateBook');
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: rootURL + '/' + $('#bookId').val(),
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Book updated successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('updateBook error: ' + textStatus);
		}
	});
}

function deleteBook() {
	console.log('deleteBook');
	$.ajax({
		type: 'DELETE',
		url: rootURL + '/' + $('#BookId').val(),
		success: function(data, textStatus, jqXHR){
			alert('Book deleted successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('deleteBook error');
		}
	});
}

function renderDetails(book) {
	$('#bookId').val(book.id);
	$('#title').val(book.title);
	$('#author').val(book.author);
	$('#prize').val(book.prize);
}

function renderList(data) {
	console.log('renderList with data: ' + data);
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#bookList li').remove();
	$.each(list, function(index, book) {
		$('#bookList').append('<li><a href="#" data-identity="' + book.id + '">'+book.title+'</a></li>');
	});
}

function formToJSON() {
	var bookId = $('#bookId').val();
	return JSON.stringify({
		"id": bookId == "" ? null : bookId, 
		"title": $('#title').val(), 
		"author": $('#author').val(),
		"prize": $('#prize').val()
		});
}