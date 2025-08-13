import pytest


@pytest.mark.activity
def test_addition():
	
	num1 = 10
	num2 = 20
    
	sum = num1 + num2
	assert sum == 30
	
@pytest.mark.activity
def test_subtraction():
  
	num1 = 50
	num2 = 20
    
	diff = num1 - num2
	assert diff == 30
	
@pytest.mark.activity
def test_multiplication():
  
	num1 = 10
	num2 = 3
    
	prod = num1 * num2
	assert prod == 30
	
@pytest.mark.activity
def test_division():
  
	num1 = 90
	num2 = 3
    
	quot = num1 / num2
	assert quot == 30