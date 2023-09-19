CFLAGS = -g -Wall
TARGET = userprog2

all: $(TARGET)

$(TARGET): $(TARGET).c
	$(CC) $(CFLAGS) $(LDFLAGS) -o $(TARGET) $(TARGET).c

install:
	install -d $(DESTDIR)
	install -m 0755 $(TARGET) $(DESTDIR)

uninstall:
	rm $(DESTDIR)$(TARGET)
