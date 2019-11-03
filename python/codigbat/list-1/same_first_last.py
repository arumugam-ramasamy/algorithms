def same_first_last(nums):
  if (len(nums) <1):
    return False 
  if (nums[0] == nums[-1]):
    return True 
  return False
