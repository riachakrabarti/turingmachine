states 12
q0
q1a
q1b
firstmatcha
firstmatchb
matchbacka
matchbackb
findbeginningagaina
findbeginningagainb
w1
Accept +
Reject -
alphabet 3 a b *
q0 a q1a * R
q0 b q1b * R
q0 _ Accept _ R
q1a a q1a a R
q1a b q1a b R
q1a _ firstmatcha _ L
q1a * matchbacka * L
firstmatcha a findbeginningagaina * L
firstmatcha _ firstmatcha _ L
matchbacka * matchbacka * R
matchbacka _ Accept _ R
matchbacka a findbeginningagaina * L
findbeginningagaina a findbeginningagaina a L
findbeginningagaina b findbeginningagaina b L
findbeginningagaina * w1 * R
w1 a q1a * R
q1b a q1b a R
q1b b q1b b R
q1b _ firstmatchb _ L
q1b * matchbackb * L
firstmatchb b findbeginningagainb * L
firstmatchb _ firstmatchb _ L
matchbackb * matchbackb * R
matchbackb b findbeginningagainb * L
matchbackb _ Accept _ R
findbeginningagainb a findbeginningagainb a L
findbeginningagainb b findbeginningagainb b L
findbeginningagainb * w1 * R
w1 b q1b * R
w1 * matchbackb * R