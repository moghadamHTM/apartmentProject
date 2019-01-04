/**
 * 
 */

$(document).ready(function(){
	$('.nBtn, .table .eBtn').on('click',function(event){
		
		event.preventDefault();

		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text == 'Edit'){
			$.get(href,function(person,status){
				$('.myForm #id').val(person.id);
				$('.myForm #name').val(person.name);
				$('.myForm #family').val(person.family);
				$('.myForm #personType').val(person.personType);
				$('.myForm #mobilePhone').val(person.mobilePhone);
				$('.myForm #phone').val(person.phone);
				
				});
		
			$('.myForm #exampleModal').modal();
		}else{
			$('.myForm #id').val('');
			$('.myForm #name').val('');
			$('.myForm #family').val('');
			$('.myForm #personType').val('');
			$('.myForm #mobilePhone').val('');
			$('.myForm #phone').val('');
			$('.myForm #exampleModal').modal();
		}
		
	});
	
	
	
	$('.table .delBtn').on('click',function(event){
		
		event.preventDefault();

		var href=$(this).attr('href');
		
		$('#myModal #delRef').attr('href',href);
		$('#myModal').modal();
		
	});
});