data Cmd = Cursor Int
           | Backspace Int
           | Delete Int
           | Insert String
           deriving (Read)
           
backspaceText :: String -> Int -> Int -> String
backspaceText text plus pos = (take (pos-plus) text) ++ (drop pos text)

deleteText :: String -> Int -> Int -> String
deleteText text plus pos = (take pos text) ++ (drop (pos+plus) text)

insertText :: String -> Int -> String -> String
insertText text pos [] = text
insertText text pos newText = (take pos text) ++ newText ++ (drop pos text)

editText :: String -> [Cmd] -> String
editText text [] = text
editText text commands =
      let
          doCommands :: (String, Int) -> [Cmd] -> (String, Int)
          doCommands textPos [] = textPos
          doCommands (text, pos) (a:as) = doCommands (updateText text a pos) as
      
          updateText :: String -> Cmd -> Int -> (String, Int)
          updateText text (Cursor x) pos = (text, pos+x)
          updateText text (Backspace x) pos = (backspaceText text x pos, pos-x)
          updateText text (Delete x) pos = (deleteText text x pos, pos)
          updateText text (Insert t) pos = (insertText text pos t, pos)
          
      in
          fst (doCommands (text, 0) commands)

main = do
       a <- getLine
       b <- getLine
       let result = editText a (read b)
       print result