data Tree t = Nilt |
              Node t (Tree t) (Tree t)
              deriving (Read)

heightDiameter :: Tree t -> (Int, Int)
heightDiameter Nilt = (0, 0)
heightDiameter (Node _ l r) = 
    let
      (leftDiameter, leftHeight) = heightDiameter l
      (rightDiameter, rightHeight) = heightDiameter r
      currHeight = 1 + (max leftHeight rightHeight)
      currDiameter = 1 + leftHeight + rightHeight
      maxDiameter = max currDiameter (max leftDiameter rightDiameter)
    in
      (maxDiameter, currHeight)
    
maiorDiametro :: Ord t => Tree t -> Int
maiorDiametro currTree = fst (heightDiameter currTree)

main = do
       s <- getLine
       let result = maiorDiametro (read s::Tree Int)
       print result