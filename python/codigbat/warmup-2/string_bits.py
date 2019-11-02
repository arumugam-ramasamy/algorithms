def string_bits(str):
  bits = "" 
  for i in range(0, len(str), 2):
    bits = bits + str[i] 
  
  return bits 
