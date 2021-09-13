# BulkBuy

Introduction – BulkBuy is an application that helps customers place bulk orders on a specific product. They can create an order and specify a shipping address, with the ability to change the product description, quantity, shipping service, and date to ship the order. The customer can also input an order message for additional details. 

When the order is complete, the customer will receive an order number, where they can view their inputted information as well as the deliverer, estimated arrival date, and shipping status. 

## Storyboard

![image](https://user-images.githubusercontent.com/35185334/133005410-e66d3918-ae9f-4dfc-aa80-6890055cd98c.png)



## Requirements

1. As a customer, I want to be able to place a bulk order (as well as input any additional information) by filling out a simple form 

### Example

Given: A customer has information to place an order for 32 decks of playing cards, and ship the product through UPS to 333 cool st in Washington, D.C. 

When: The user inputs all of this information into the form 

Then: The customer will receive a confirmation of their order, with an order number, status and arrival date. The deliverer will be a UPS carrier. 


### Example

Given: A customer wants to place an order for 500 fishing poles to 486 e Michigan st in Columbus, OH. The customer leaves a message to ring the doorbell on arrival. 

When: The user inputs all of this information into the form 

Then: The customer will receive a confirmation of their order, with an order number, status and arrival date. The order message will display the input from the customer. 

 
 ### Example

Given: A customer wants to place an order for 6000 toaster ovens. The customer does not put in a delivery address 

When: the user inputs all of this information into the form 

Then: The application will prompt the customer to input a delivery address. The order will not complete. 


2. As someone who has placed an order, I want to be able to use the given order number to look up my past order and find my information, as well as some estimations for my shipment. 

### Example

Given: A customer has the order number 4215. 

When: The user inputs their order number into the order lookup form 

Then: The customer will then be given their past order information. 

 
 ### Example

Given: A customer has the order number 1235345, which does not exist in the database. 

When: The user inputs their order number into the order lookup form 

Then: The application will prompt the user that this order does not exist. 

 
 ### Example

Given: A customer uses the order lookup form, using the string ‘1io4jorj’. 

When: The user inputs this string into the order lookup form 

Then: The application will prompt the user that order numbers are number only, and to input an order number. 

## JSON Schema

>{ 
>	“type” : “object”, 
>		“properties” : { 
>			“orderNumber” : { 
>				“type” : “integer” 
>			}, 
>			“qty” : {
>				“type” : “integer”
>			}, 
>			“description” : {
>				“type” : “string”
>			}, 
>			“orderDate” : {
>				“type” : “string” 
>			}, 
>			“estimatedArrival” : {
>				“type” : “string”
>			}, 
>			“carrier” : {
>				“type” : “string”
>			}, 
>			“status” {
>				“type” : “string”
>			}
>		}
>	} 

## Class Diagram

![image](https://user-images.githubusercontent.com/77906864/133007918-a9c1907c-3ac9-46f4-b4ae-925a53e77e30.png)

## Class Descriptions

### com.bulkbuy.ui

Controller - Controller for the UI

OrderLayout - Format for the Order lookup and placement pages

LookupOrder - Collects order ID to find order with the given ID

CreateOrder - Handles information given from the user to place an order.


### com.bulkbuy.dto

Order - Basic Object class to store information for orders.


### com.bulkbuy.service

IOrderService, OrderService, OrderServiceStub - handles sending information from the UI to the database


### com.bulkbuy.dao

IOrderDAO, OrderDAO, OrderDAOStub - handles data retrieval and storage for the application

## Team Members & Roles

**UI Specialist**: Brendan Root

**UI Specialist**: Maximiliano De Santiago Galan

**Business Logic and Persistence Specialist**: Brandon Matalka

**Business Logic and Persistence Specialist**: Blake Barr

**Product Owner/Scrum Master/DevOps/GitHub Administrator**: Nathan Coffee

## Milestones

[Milestone 1](https://github.com/coffee-ns/BulkBuy/milestone/1)

[Milestone 2](https://github.com/coffee-ns/BulkBuy/milestone/2)

[Milestone 3](https://github.com/coffee-ns/BulkBuy/milestone/3)

## Standup

[We meet weekly at 8:00PM on Sundays](https://teams.microsoft.com/l/meetup-join/19%3ameeting_NTdhYmY4N2YtNTIwMC00MjIzLTg5YWMtMWE0MTBmODI5ZWJj%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%22f763efca-3726-4129-8023-2d5dda742031%22%7d)
