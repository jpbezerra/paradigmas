menorMaior :: Int -> Int -> Int -> (Int, Int)
menorMaior x y z = (menor x y z, maior x y z)
  where menor a b c
          | a <= b && a <= c = a
          | b <= a && b <= c = b
          | otherwise        = c
        maior a b c
          | a >= b && a >= c = a
          | b >= a && b >= c = b
          | otherwise        = c

ordenaTripla :: (Int, Int, Int) -> (Int, Int, Int)
ordenaTripla (x, y, z) = (a, b, c)
  where (a, c) = menorMaior x y z
        b      = x + y + z - a - c

type Ponto = (Float, Float)
type Reta  = (Ponto, Ponto)

primeiraCoordenada :: Ponto -> Float
primeiraCoordenada (x, y) = x

segundaCoordenada :: Ponto -> Float
segundaCoordenada (x, y) = y

primeiroPonto :: Reta -> Float
primeiroPonto (p1, p2) = primeiraCoordenada p1

segundoPonto :: Reta -> Float
segundoPonto (p1, p2) = segundaCoordenada p2

vertical :: Reta -> Bool
vertical (p1, p2) = primeiraCoordenada p1 == primeiraCoordenada p2

pontoY :: Float -> Reta -> Float
pontoY x (p1, p2) = y1 + m * (x-x1)
    where
        y1 = segundaCoordenada p1
        x1 = primeiraCoordenada p1
        y2 = segundaCoordenada p2
        x2 = primeiraCoordenada p2
        m  = (y2-y1)/(x2-x1)

main :: IO ()
main = do
    print (menorMaior 3 1 2)
    print (ordenaTripla (3, 1, 2))
    print (primeiraCoordenada (1.0, 2.0))
    print (segundaCoordenada (1.0, 2.0))
    print (primeiroPonto ((1.0, 2.0), (3.0, 4.0)))
    print (segundoPonto ((1.0, 2.0), (3.0, 4.0)))
    print (vertical ((1.0, 2.0), (1.0, 4.0)))
    print (vertical ((1.0, 2.0), (3.0, 4.0)))
    print (pontoY 2.0 ((1.0, 2.0), (3.0, 4.0)))