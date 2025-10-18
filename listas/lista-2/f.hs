parseNota :: String -> Float
parseNota "A+" = 9.7
parseNota "A" = 9.3
parseNota "A-" = 9
parseNota "B+" = (parseNota "A+") - 1
parseNota "B" = (parseNota "A") - 1
parseNota "B-" = (parseNota "A-") - 1
parseNota "C+" = (parseNota "B+") - 1
parseNota "C" = (parseNota "B") - 1
parseNota "C-" = (parseNota "B-") - 1
parseNota "D+" = (parseNota "C+") - 1
parseNota "D" = (parseNota "C") - 1
parseNota "D-" = (parseNota "C-") - 1
parseNota "F" = 5.9

getMedia :: [String] -> Float
getMedia [] = 0
getMedia as = soma / fromIntegral (length as)
    where soma = sum (map parseNota as)

parseFaculdade :: Float -> [String] -> Int
parseFaculdade _ [] = 0
parseFaculdade media (a:as)
    | media >= notaFaculdade = 1 + (parseFaculdade media as)
    | otherwise = parseFaculdade media as
    where notaFaculdade = parseNota a

contagemNotas :: [String] -> [String] -> Int
contagemNotas notas faculdades = parseFaculdade (getMedia notas) faculdades

main = do
    a <- getLine
    b <- getLine
    print (contagemNotas (read a) (read b))