def array123(nums):
  seq = 1 
  if (len(nums) < 3):
    return False 
  for i in range(len(nums)):
    if (seq == nums[i]):
      seq += 1
    else:
      if (nums[i] == 1):
        seq = 2
      else :
        seq = 1
    if (seq == 4):
      return True
  
  if (seq == 4) :
      return True 
  else:
      return False
