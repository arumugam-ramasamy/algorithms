def string_splosion(str):
  splosion = ""
  for i in range(len(str)+1):
    splosion = splosion + str[0:i]
  return splosion 
