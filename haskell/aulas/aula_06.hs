agrupar :: Eq t => [[t]] -> [(t, Int)]
agrupar xss = contar (concat xss)
  where
    contar [] = []
    contar (x:xs) = (x, 1 + length [y | y <- xs, y == x]) : contar (filter (/= x) xs)

main :: IO ()
main = do
    let listas = [["a", "b", "c"], ["a", "b", "a"], ["d", "e", "a"]]
    print (agrupar listas)