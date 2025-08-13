import pytest

@pytest.mark.activity
@pytest.mark.parametrize("earned, spent, expected", [ (30, 10, 20), (20, 2, 18)])
def test_balance(wallet, earned, spent, expected):
	
    wallet += earned
    wallet -= spent
    assert wallet == expected