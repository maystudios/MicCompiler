# Maystudios Custom Mic1 Compiler

This repository contains a custom compiler developed by Maystudios for the Mic1 architecture. The compiler is designed to process a hypothetical assembly-like language and convert it into binary machine code that can be executed by the Mic1 processor. This project includes several specialized parsers and utility classes to handle various aspects of the compilation process, from parsing memory operations to handling ALU instructions.

## Table of Contents

- [Overview](#overview)
- [What is Mic1?](#what-is-mic1)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Detailed Components](#detailed-components)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Maystudios Custom Mic1 Compiler is a Java-based tool that reads source files written in a custom assembly language and outputs binary machine code for the Mic1 processor. The compiler is modular, with various components handling specific aspects of the parsing and compilation process.

## What is Mic1?

Mic1 is a simplified model of a microprogrammed processor, primarily used in educational contexts to teach the fundamentals of computer architecture and microprogramming. It breaks down the control logic of a CPU into microinstructions stored in a control store, allowing students to explore CPU internals in a simplified environment.

### Why Use Mic1?

- **Educational Tool**: Mic1 is widely used in computer science courses to help students understand CPU architecture, microprogramming, and low-level machine code execution.
- **Microprogramming**: Mic1 offers a practical way to learn about microprogramming, the process of writing the microcode that controls CPU instruction execution.
- **Hands-On Learning**: Working with a Mic1 simulator or compiler like this one provides hands-on experience with the low-level operations of a CPU.

### What Does This Compiler Do?

This compiler translates high-level assembly-like language specific to the Mic1 architecture into binary machine code that the Mic1 processor can execute. The process includes:

1. **Input Source Code**: The compiler takes source code written in a custom assembly-like language.
2. **Parsing**: Specialized parsers convert various components of the source code (e.g., memory operations, register operations, ALU operations) into binary code.
3. **Compilation**: The `MicCompiler` class coordinates all parsers to compile the source file into a binary output.
4. **Output**: The compiler generates a binary file that can be executed by a Mic1 simulator or emulator.

### Use Cases for the Mic1 Compiler

- **Academic Projects**: Ideal for students working on projects related to CPU architecture and microprogramming.
- **CPU Simulation**: The binary output can be run in a Mic1 simulator to observe instruction execution.
- **Research**: Useful for exploring custom CPU architectures and low-level machine code generation.

## Project Structure

Here is an overview of the key components in this project:

- **MemoryParser.java**: Parses and translates memory-related instructions into binary code.
- **MicCompiler.java**: The central class that manages the compilation process by coordinating with other parsers and utilities.
- **RegisterParser.java**: Handles the translation of register operations into binary.
- **AdresseParser.java**: Manages address-related instructions, including "goto" statements.
- **AluParser.java**: Converts ALU (Arithmetic Logic Unit) operations into binary format.
- **CommentParser.java**: Removes comments from the input code to ensure clean compilation.
- **lib.java**: Utility class with methods for converting integers to binary strings of specified lengths.
- **FileReader.java**: Facilitates reading and validating input `.may` files.
- **FileWriter.java**: Manages writing the compiled binary output to files.

## Installation

To get started with this project:

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/Maystudios/compiler-project.git
    ```

2. Navigate into the project directory:

    ```bash
    cd compiler-project
    ```

3. Compile the Java source files:

    ```bash
    javac -d bin src/*.java
    ```

    This command compiles all Java files and places the output in the `bin` directory.

## Usage

To use the compiler, you need to provide it with an input file and specify an output file. Here's an example:

```bash
java -cp bin MicCompiler inputfile.may outputfile.bin
