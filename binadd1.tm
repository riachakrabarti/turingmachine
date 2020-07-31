states 21
q0
w1zonew1=0
w1zonew1=1
w2zonew1=1
w2zonew1=1w2=0
w3zonew1=1w2=0
Reject -
w3iscarryings1
gobackw3
gobackw2
gobackw1
zone1again
w2zonew1=1w2=1
w3zonew1=1w2=1
w3iscarryings3
w2zonew1=0
w2zonew1=0w2=0
w3zonew1=0w2=0
w3iscarryings2
Accept +
w2zonew1=0w2=1
alphabet 5 1 0 # * c
q0 1 w1zonew1=1 * R
w1zonew1=1 0 w1zonew1=1 0 R
w1zonew1=1 1 w1zonew1=1 1 R
w1zonew1=1 # w2zonew1=1 # R
w2zonew1=1 * w2zonew1=1 * R
w2zonew1=1 0 w2zonew1=1w2=0 * R
w2zonew1=1w2=0 0 w2zonew1=1w2=0 0 R
w2zonew1=1w2=0 1 w2zonew1=1w2=0 1 R
w2zonew1=1w2=0 # w3zonew1=1w2=0 # R
w3zonew1=1w2=0 * w3zonew1=1w2=0 * R
w3zonew1=1w2=0 0 Reject 0 R
w3zonew1=1w2=0 c w3iscarryings1 * R
w3zonew1=1w2=0 1 gobackw3 * L
w3iscarryings1 1 Reject 1 R
w3iscarryings1 0 gobackw3 c L
gobackw3 * gobackw3 * L
gobackw3 # gobackw2 # L
gobackw2 0 gobackw2 0 L
gobackw2 1 gobackw2 1 L
gobackw2 * gobackw2 * L
gobackw2 # gobackw1 # L
gobackw1 0 gobackw1 0 L
gobackw1 1 gobackw1 1 L
gobackw1 * zone1again * R
zone1again 1 w1zonew1=1 * R
w2zonew1=1 # w3zonew1=1w2=0 # R
w2zonew1=1 1 w2zonew1=1w2=1 * R
w2zonew1=1w2=1 0 w2zonew1=1w2=1 0 R
w2zonew1=1w2=1 1 w2zonew1=1w2=1 1 R
w2zonew1=1w2=1 # w3zonew1=1w2=1 # R
w3zonew1=1w2=1 * w3zonew1=1w2=1 * R
w3zonew1=1w2=1 1 w3zonew1=1w2=1 * R
w3zonew1=1w2=1 0 gobackw3 c L
w3zonew1=1w2=1 c w3iscarryings3 * R
w3iscarryings3 1 gobackw3 c L
w3iscarryings3 0 w3iscarryings3 0 R
q0 0 w1zonew1=0 * R
w1zonew1=0 0 w1zonew1=0 0 R
w1zonew1=0 1 w1zonew1=0 1 R
w1zonew1=0 # w3zonew1=0w2=0 # R
q0 # w2zonew1=0 # R
w2zonew1=0 * w2zonew1=0 * R
zone1again 0 w1zonew1=0 * R
zone1again # w2zonew1=0 # R
w2zonew1=0 1 w2zonew1=0w2=1 * R
w2zonew1=0w2=1 0 w2zonew1=0w2=1 0 R
w2zonew1=0w2=1 1 w2zonew1=0w2=1 1 R
w2zonew1=0w2=1 # w3zonew1=1w2=0 # R
w2zonew1=0 0 w2zonew1=0w2=0 * R
w2zonew1=0w2=0 0 w2zonew1=0w2=0 0 R
w2zonew1=0w2=0 1 w2zonew1=0w2=0 1 R
w2zonew1=0w2=0 # w3zonew1=0w2=0 # R
w2zonew1=0 # w3zonew1=0w2=0 # R
w3zonew1=0w2=0 * w3zonew1=0w2=0 * R
w3zonew1=0w2=0 0 gobackw3 * L
w3zonew1=0w2=0 1 Reject 1 L
w3zonew1=0w2=0 c w3iscarryings2 * R
w3iscarryings2 1 gobackw3 * L
w3iscarryings2 0 Reject 0 R
w3zonew1=0w2=0 _ Accept _ L
w2zonew1=0 _ Accept _ R