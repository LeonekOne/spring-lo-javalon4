Git - good practices

* commit powinien mieć dobry opis
* commit powinien zawierać jedną zmianę
* zmiana opisu tylko dla ostatniego commita (amend)
* podróżuj po historii i branchach tylko przy czystym drzewie roboczym
* git flow - w skrócie
    * master - branch release'owy
    * develop - branch developerski
    * feature branch - branch do rozwoju funkcjonalności
    * feature branch - powinien startować od developa i do niego finalnie zostać zmergowany
    * przed mergem brancha feature'owego do jednego z głównych (develop lub master) najpierw zmerguj główny do obecnego (wymuszony commit mergujący)    
    * później na głównym branchu możemy zmergować ten feature'owy za pomocą fast forward
* branch
    * własny branch nie musi być idealny (może nie działać, może zawierać komentarze FIXME/TODO),
      ale wysłanie merge requesta z tego brancha musi zawierać "piękny kod"
    * usuwanie branch'y
        * zmergowany branch można usunąć
        * nie powinniśmy usuwać nie zmergowanych branch'y bo nie będziemy w stanie wrócić do nich
        * nie usuwamy branch'a na którym aktualnie się znajdujemy:)
    * mergowanie
        * fast forward nie zawsze jest możliwy - działa tylko w przypadku gdy jeden branch może "dogonić" drugi
        * zawsze można wymusić commit mergujący
        * pull'uj branch'e tylko przy czystym drzewie roboczym
* współpraca zdalna
    * publikuj nowe feature'y na feature branch'ach
    * przed zgłoszeniem pull request'a zawsze najpierw zmerguj zmiany do siebie z docelowego branch'a
    * konflikty rozwiązuj zawsze na swoim branchu
    * pull request - procedura
        * zrób forka docelowego repozytorium
        * zrób feature branch od developa
        * przełącz się na lokalny branch develop
        * zrób pull z oryginalnego repozytorium
        * zrób push'a do mojego zdalnego repozytorium (wyrównuje developa pomiędzy moim zdalnym a oryginalnym)
        * wróć na feature branch
        * zmerguj do siebie zmiany z lokalnego developa
        * wypchnij feature branch do swojego zdalnego repo
        * zgłoś pull request:)
        * w razie problemów powtórz :)
* tymczasowe odkładanie zmian
    * możemy użyć stash'a, ale:
        * możemy pomylić branch'e przy zdejmowaniu
        * stash nie jest związany z żadnym branchem i może zawierać tymczasowe zmiany z różnych miejsc
    * używajmy tymczasowych commit'ów
    * oznaczajmy je przez prefix [WIP] - work in progress
    * po powrocie z innego branch'a kasujmy commit lub wykonajmy amend
    * jak kasowac commit'y:
        * zrób dodatkowy branch wskazujący na obecny commit (na wszelki wypadek)
        * wybierz jakiś wcześniejszy commit
        * opcja reset (najlepiej soft - commit/commit'y zostaje skasowany, zmiany wracają do drzewa roboczego)
        * wykonaj nowy, już prawidłowy commit z docelowymi zmianami
        * reset --hard - kasuje commit (prawie) bezpowrotnie
    * pamiętaj że przy użyciu git reflog możesz przywrócić skasowane i niewidoczne commit'y
    
Git - przydatne komendy
git status
git add .
git add file-name
git add file-name1 file-name2
git commit -m "[tag] - message"
git restore --staged file-name // zdejmij ze stage'a
git checkout branch-name // przełącz się na branch-name
git checkout -b branch-name // przełącz na nowo utworzony branch
git log --graph // rysuje graf historii w konsoli
git branch -a // pokaż wszystkie branch'e
git fetch // aktualizacja metadanych o zdalnych repozytoriach
git branch -d feature/animal-mp - usuwa zmergowany branch
git stash - odłóż na półke 
git stash list - pokaż co jest na półce (stash jest stosem)
git stash pop - zdejmij z półki
git stash apply - zaaplikuj ostatnie zmiany ze stash'a
git reflog - pokaż dziennik git'a (pomaga przy utraconych commit'ach)
