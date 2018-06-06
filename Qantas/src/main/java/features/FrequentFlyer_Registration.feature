Feature: Qantas Frequent Flyer Registration form filling 
Scenario: User enter all the personal details on the frequent flyer page 
	Given Qantas frequent flyer registration url 
	When the form is ready for entering details 
	Then user enters the personal details 
		|Title|First_Name|Last_Name|Mobile_Number|
		|Mr|Rajaneesh|Balakrishnan|0423149505|
	Then user enters the address details 
		|Address_Line1|Address_Line2|Suburb|State|PostalCode|
		|67|Girraween_Road|Girraween|7|2145|
	Then user enters the email and consent 
		|Email|Email_Confirmation|
		|sydneyrajaneesh@gmail.com|sydneyrajaneesh@gmail.com|
	Then the user enters the security information
		|Date|Month|Year|Mothers_Maiden_name|create_pin|confirm_pin|
		|17|3|85|Rajam|9809|9809|
	Then the user accepts the terms and conditions
		