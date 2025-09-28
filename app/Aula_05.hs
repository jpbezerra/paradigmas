type Pessoa = String
type Livro = String
type BancoDados = [(Pessoa,Livro)]

baseExemplo :: BancoDados
baseExemplo = [
    ("Sergio","O Senhor dos Aneis"),
    ("Andre","Duna"),
    ("Fernando","Jonathan Strange & Mr. Norrell"),
    ("Fernando","A Game of Thrones"),
    ("Sergio","1984"),
    ("Andre","O Senhor dos Aneis"),
    ("Fernando","Duna")
    ]

livros :: BancoDados -> Pessoa -> [Livro]
livros bd p = [l | (pessoa,l) <- bd, pessoa == p]

emprestimos :: BancoDados -> Livro -> [Pessoa]
emprestimos bd l = [p | (p, livro) <- bd, livro == l]

emprestado :: BancoDados -> Livro -> Bool
emprestado bd l = emprestimos bd l /= []

qtdEmprestimos :: BancoDados -> Pessoa -> Int
qtdEmprestimos bd p = length (livros bd p)

emprestar :: BancoDados -> Pessoa -> Livro -> BancoDados
emprestar [] p l = [(p,l)]
emprestar ((p, l):xs) pessoa livro
    | p == pessoa && l == livro = ((p,l) : xs)
    | otherwise                 = (p,l) : emprestar xs pessoa livro

devolver :: BancoDados -> Pessoa -> Livro -> BancoDados
devolver [] _ _ = []
devolver ((p, l):xs) pessoa livro
    | p == pessoa && l == livro = xs
    | otherwise                 = (p,l) : devolver xs pessoa livro

main :: IO ()
main = do
    putStrLn (show (livros baseExemplo "Fernando"))
    putStrLn (show (emprestimos baseExemplo "Duna"))
    putStrLn (show (emprestado baseExemplo "Duna"))
    putStrLn (show (qtdEmprestimos baseExemplo "Fernando"))
    putStrLn (show (emprestar baseExemplo "Joao" "O Hobbit"))
    putStrLn (show (devolver baseExemplo "Fernando" "Duna"))