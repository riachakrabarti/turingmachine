states 21
q0
w1zonew1=1
w1zonew1=0
w2zonew1=1
w2zonew1=1w2=0
w2zonew1=0
w2zonew1=0w2=1
w2zonew1=1w2=1
w2zonew1=0w2=0
w3zonew1=0w2=0
w3zonew1=1w2=0
w3zonew1=1w2=1
w3carryw1=1w2=1
w3carryw1=1w2=0
w3carryw1=0w2=0
w3goback
w2goback
w1goback
w1zonefindnext
Accept +
Reject -
alphabet 5 1 0 # c *
q0 1 w1zonew1=1 * R
q0 0 w1zonew1=0 * R
q0 # w2zonew1=0 # R
q0 _ Accept _ R
w1zonew1=1 0 w1zonew1=1 0 R
w1zonew1=1 1 w1zonew1=1 1 R
w1zonew1=1 # w2zonew1=1 # R
w2zonew1=1 * w2zonew1=1 * R
w1zonew1=0 0 w1zonew1=0 0 R
w1zonew1=0 1 w1zonew1=0 1 R
w1zonew1=0 # w2zonew1=0 # R
w2zonew1=0 * w2zonew1=0 * R
w2zonew1=0 0 w2zonew1=0w2=0 * R
w2zonew1=0 1 w2zonew1=0w2=1 * R
w2zonew1=0 _ w2zonew1=0w2=0 _ R
w2zonew1=1 1 w2zonew1=1w2=1 * R
w2zonew1=1 0 w2zonew1=1w2=0 * R
w2zonew1=1w2=0 0 w2zonew1=1w2=0 0 R
w2zonew1=1w2=0 1 w2zonew1=1w2=0 1 R
w2zonew1=1w2=1 0 w2zonew1=1w2=1 0 R
w2zonew1=1w2=1 1 w2zonew1=1w2=1 1 R
w2zonew1=0w2=1 0 w2zonew1=0w2=1 0 R
w2zonew1=0w2=1 1 w2zonew1=0w2=1 1 R
w2zonew1=0w2=0 0 w2zonew1=0w2=0 0 R
w2zonew1=0w2=0 _ w2zonew1=0w2=0 * L
w2zonew1=0w2=0 1 w2zonew1=0w2=0 1 R
w2zonew1=1w2=0 # w3zonew1=1w2=0 # R
w2zonew1=1w2=1 # w3zonew1=1w2=1 # R
w2zonew1=0w2=1 # w3zonew1=1w2=0 # R
w2zonew1=0w2=0 # w3zonew1=0w2=0 # R
w2zonew1=0 # w3zonew1=0w2=0 # R
w2zonew1=1 # w3zonew1=1w2=0 # R
w3zonew1=1w2=1 * w3zonew1=1w2=1 * R
w3zonew1=1w2=1 0 w3goback c L
w3zonew1=1w2=1 c w3carryw1=1w2=1 * R
w3carryw1=1w2=1 1 w3goback c L
w3goback * w3goback * L
w3zonew1=1w2=0 * w3zonew1=1w2=0 * R
w3zonew1=1w2=0 1 w3goback * L
w3zonew1=1w2=0 c w3carryw1=1w2=0 * R
w3carryw1=1w2=0 0 w3goback c L
w3zonew1=0w2=0 * w3zonew1=0w2=0 * R
w3zonew1=0w2=0 0 w3goback * L
w3zonew1=0w2=0 c w3carryw1=0w2=0 * R
w3carryw1=0w2=0 1 w3goback * L
w3zonew1=0w2=0 _ Accept _ R
w3goback # w2goback # L
w2goback * w2goback * L
w2goback 1 w2goback 1 L
w2goback 0 w2goback 0 L
w2goback # w1goback # L
w1goback * w1zonefindnext * R
w1goback # w2zonew1=0 # R
w1goback 0 w1goback 0 L
w1goback 1 w1goback 1 L
w1zonefindnext # w2zonew1=0 # R
w1zonefindnext 0 w1zonew1=0 * R
w1zonefindnext 1 w1zonew1=1 * R
w3goback _ Accept _ L