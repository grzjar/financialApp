# financialApp

Aplikacja <b>financialApp</b> jest projektem zaliczeniowym dla kursu <i>Java Backend Developer</i> w szkole Coderslab.

### O aplikacji:
Aplikacja oparta jest o Springa i w nim też została napisana. Jej celem jest zarządzanie przychodami i wydatkami z kont użytkownika.<br>
Ponadto, aplikacja wykorzystuje bazę danych w MySQL, 8 Dialect.

### Funkcjonalności:
<b>Po uruchomieniu aplikacji, użytkownik może:</b>
- zarejestrować się
- zalogować
- przenieść na stronę ReadMe

Aplikacja nie pozwala na korzystanie z dalszych funkcjonalności bez uprzedniej rejestracji i zalogwania użytkownika.

<b>Zalogowany użytkownik:</b><br>
- utworzyć konto
- wylogować się

<b>W następnym krokach:</b>
Po utworzeniu konta użytkownik może skorzystać z kilku akcji: <i>Pokaż</i>, <i>Edytuj</i> lub <i>Usuń</i>.

Każdorazowe przejście do konta przy użyciu akcji <i>Pokaż</i>, wyświetli szczegółowe dane konta z sumą przychodów, wydatków i sumą na koncie*.<br>
Z tego miejsca użytkownik może <i>Dodać przychód</i>, <i>Dodać wydatek</i>, <i>Pokazać kategorie</i>.<br>
Wszystkie przychody, wydatki i kategorie są określona per użytkownik. Zatem, każdy może posiadać swoje kategorie.

Użytkownik może posiadać więcej niż jedno konto - wówczas, po powrocie na stronę główną, wyświetlać będą mu się wszystkie konta, a szczegółowy dostęp do nich będzie po wybraniu akcji <i>Pokaż</i>.<br>
Akcja <i>Usuń</i> usuwa wszystkie dane powiązane z kontem.

Wszystkie akcje, po dodaniu przychodu, wydatku lub kategorii, działają analogicznie.

W późniejszym etapie możliwy jest dalszy rozwój aplikacji, np. poprzez stworzenie możliwości wyświetlania przychodów/wydatków per kategoria.

*Pod warunkiem, że określono przynajmniej po jednym przychodzie i wydatku.