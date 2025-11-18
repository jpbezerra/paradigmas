-- versão 1
fibonacci_v1 :: [Int]
fibonacci_v1 = map fib [0..]

fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

-- versão 2
fibonacci :: [Int]
fibonacci = gen_fib 0 1

gen_fib x1 x2 = x1 : gen_fib x2 (x1+x2)

-- para testar: take 20 fibonacci

primes :: [Int]
primes = gen_primes [2..]

gen_primes :: [Int] -> [Int]
gen_primes (p:ps) = p : gen_primes [x | x <- ps, x `mod` p /= 0]

merge :: [Int] -> [Int] -> [Int]
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys) | x < y = x : merge xs (y:ys)
                    | x >= y = y : merge (x:xs) ys

-- versão 1
mergeSort_v1 :: [Int] -> [Int]
mergeSort_v1 [] = []
mergeSort_v1 (x:xs) = merge [x] (mergeSort_v1 xs)

-- versão 2
mergeSort_v2 :: [Int] -> [Int]
mergeSort_v2 [] = []
mergeSort_v2 xs = foldr1 merge (sublistas_ordenadas xs)

-- separa a lista em uma lista de listas cujos elementos estão ordenados
sublistas_ordenadas [] = []
sublistas_ordenadas xs = ord_xs : sublistas_ordenadas (drop (length (ord_xs)) xs)
  where ord_xs = ordenada xs

-- retorna uma lista com os elementos que estão em ordem no início da lista 
ordenada [] = []
ordenada [x] = [x]
ordenada (x:y:xys) | x <= y = x : ordenada (y:xys)
                   | otherwise = [x] -- x fica como último elemento que estava ordenado

main :: IO ()
main = do
    print (take 20 fibonacci)
    print (take 20 primes)
    print (merge [1,3,5,7] [2,4,6,8])
    print (mergeSort_v1 [5,3,8,6,2,7,4,1])
    print (mergeSort_v2 [5,3,8,6,2,7,4,1])