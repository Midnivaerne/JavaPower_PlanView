Manual - JavaPower_PlanView

Opis produktu:
  System do rozliczania czasu pracy pracowników. Aplikacja pokazuje raporty dotyczące przepracowanych godzin.

Uruchomienie programu
 W celu uruchomienia programu do generowania raportów należy uruchomić plik JAR.
 
 Plik JAR można uruchomić na kilka sposobów (działanie zależne ustatwień od systemu operacyjnego):
- dwukrotnie klikając na jego ikonie,
- klikając prawym klawiszem i wybierając odpowiednią opcję z menu kontekstowego,
- z linii poleceń poprzez wpisanie: java -jar NazwaArchiwum.jar. 

Na konsoli pojawia się informacja: Witamy w systemie generowania raportów


Wczytywanie danych
	W celu wczytania danych podaj ścieżkę do danych wejściowych. Na konsoli pojawia się informacja: 
	„Podaj ścieżkę do danych wejściowych:”
  
  
Generowanie raportów
1. System umożliwia generowanie pięciu rodzajów raportów:
	1. Raport roczny wg wszystkich pracowników
	2. Raport roczny wg projektów
	3. Raport roczny pracownika
	4. Raport roczny pracownika wg projektu [%]
	5. Raport roczny ujmujący top 10 zadań wykonanych przez pracowników [%]
  
Wybierz rodzaj raportu - w tym celu wprowadź cyfrę odpowiadającą rodzajowi raportu, który chcemy wygenerować.

// W przypadku jeśli raport jest jeszcze niedostępny pojawi się napis „!!! Raport niedostępny, wybierz inny !!!”.


2. Na ekranie pojawi się komunikat „Podaj rok:” Należy wpisać rok za który chcemy wygenerować raport.

3. Należy podać format wyjściowy raportu wpisując literę wg instrukcji na ekranie:
	K - Konsola
	E - Excel
	P - Pdf
	W - Excel z wykresem
  
// W przypadku, gdy raport jest niedostępny w danym formacie pojawia się komunikat: „!!! Wybacz, funkcja niedostępna, spróbuj jeszcze raz !!!”.
Dla błędniej wprowadzonej litery pojawi się komunikat: „!!! Nie ma takiego rodzaju, spróbuj jeszcze raz !!!”.



Użytkownik na każdym kroku działania programu ma możliwość powrotu do menu głównego klikając klawisz „m”. 
Aby zakończyć użytkowanie aplikacji wciśnij klawisz „q”.


******** Instrukcja tworzenia pliku JAR dla IntelliJ ********
File -> new -> project -> maven -> create a package
