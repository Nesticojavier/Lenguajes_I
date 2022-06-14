KC=	kotlinc
KFLAG=	-cp

all:	\
	buddy.class \
	MainKt.class

buddy.class: buddy.kt
	$(KC) $(KFLAG) . buddy.kt

MainKt.class: Main.kt 
	$(KC) $(KFLAG) . Main.kt

clean:
	rm -rf *.class META-INF
