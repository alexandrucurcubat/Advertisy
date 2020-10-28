# mtapo
Advertisy

# pentru a clona proiectul
git clone https://github.com/alexandrucurcubat/mtapo.git

# creeaza branch nou si se muta pe branchul creat
git checkout -b [nume_branch] 

# sterge branchul respectiv
git branch -d [nume_branch]

# afiseaza branch-uri create
git branch

# adauga toate fisiere si le pregateste pentru commit
git add . 

# face commit si adauga mesajul respectiv
git commit -m '[mesaj]' 

# incarca branchul pe repository.
git push --set-upstream origin [nume_branch]

# modifica ultimul commit fara a creea unul nou.
git commit --amend

# fisierul gitignore si semnificatia semnelor
.gitignore - numele fisierului ce contine numele fisierelor de ignorat
! - important ( inseamna ca fisierul nu o sa fie ignorat)
/[file_name] - doar fisierul specificat din folderul curent
* - wild card (ex: /* adauga toate fisierele din directorul curent)
# - comentariu


