cmake_minimum_required(VERSION 3.24.2)

project(mycmake)

add_executable(mycmake main.c)

install(TARGETS mycmake DESTINATION bin)
