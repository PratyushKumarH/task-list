from typing import Optional, IO


class Console:
    def __init__(self, input_reader: IO, output_writer: IO) -> None:
        self.input_reader = input_reader
        self.output_writer = output_writer

    def print(self, string: Optional="", end: str="\n", flush=True) -> None:
        self.output_writer.write(string + end)
        if flush:
            self.output_writer.flush()

    def input(self, prompt: str="") -> str:
        self.print(prompt, end="")
        return self.input_reader.readline().strip()
