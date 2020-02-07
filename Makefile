JAVACMD=java -jar PbnJVeri.jar 

.phony: ten twemty twentyone error10 error20 error21

all: ten twemty twentyone

ten: 
	$(JAVACMD) correct_10.pbn

twemty:
	$(JAVACMD) correct_20.pbn

twentyone:
	$(JAVACMD) correct_21.pbn

error10: 
	$(JAVACMD) errors_10.pbn

error20: 
	$(JAVACMD) errors_20.pbn

error21:
	$(JAVACMD) errors_21.pbn