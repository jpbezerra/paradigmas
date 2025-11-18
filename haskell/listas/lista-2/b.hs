data Command = Forward Int | Backward Int | TurnLeft | TurnRight 
               deriving (Eq, Show, Read)

data Orientation = North | South | East | West
                   deriving (Eq, Show, Read)
               
destination :: (Int,Int) -> [Command] -> (Int,Int)
destination (x, y) [] = (x, y)
destination (x, y)  commands = 
      let
          doCommand :: ((Int, Int), Orientation) -> [Command] -> ((Int, Int), Orientation)
          doCommand state [] = state
          doCommand state (a:as) = doCommand (atualizarCoordenadas (fst (state)) a (snd (state))) as
      
          atualizarCoordenadas :: (Int, Int) -> Command -> Orientation -> ((Int, Int), Orientation)
          atualizarCoordenadas (x, y) (Forward n) o
                | o == North = ((x, y+n), o)
                | o == South = ((x, y-n), o)
                | o == East = ((x+n, y), o)
                | o == West = ((x-n, y), o)
          atualizarCoordenadas (x, y) (Backward n) o
                | o == North = ((x, y-n), o)
                | o == South = ((x, y+n), o)
                | o == East = ((x-n, y), o)
                | o == West = ((x+n, y), o)
          atualizarCoordenadas (x, y) TurnLeft o
                | o == North = ((x, y), West)
                | o == West  = ((x, y), South)
                | o == South = ((x, y), East)
                | o == East  = ((x, y), North)
          atualizarCoordenadas (x, y) TurnRight o
                | o == North = ((x, y), East) 
                | o == West  = ((x, y), North)
                | o == South = ((x, y), West) 
                | o == East  = ((x, y), South)
      in
          fst (doCommand ((x, y), North) commands)

main = do
       a <- getLine
       b <- getLine
       let result = destination (read a) (read b)
       print result