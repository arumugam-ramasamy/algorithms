def pos_neg(a, b, negative):
  if (negative == True and a < 0 and b < 0):
    return True 
  if (((a < 0 and b > 0) or (a > 0 and b < 0)) and negative == False):
    return True 
  return False 
