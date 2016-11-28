[![[license: GPLv3]][1]][2]
## VisualProgramming

![Demo](images/demo.gif?raw=true "Demo")

- [What is `VisualProgramming`?](#what-is-visualprogramming)
- [Node Types](#node-types)
- [Features](#features)
- [Technical details](#technical-details)
- [License](#license)

What is VisualProgramming?
--------------------------
An Unreal Engine 4 Blueprint inspired Data Flow Editor. 

This is my hobby project to practise programming in big projects and get a better understanding on how Data Flow works.

The input of the RenderNode is visualized at the bottom left corner. It can be set using a combination of the available nodes.
The colors are from 0 to 1 and every Node returns and accepts Doubles.

Nodes Types:
------------
* Render Node ✓
* ConstNode ✓
* AddNode ✓
* MultiplyNode ✓
* AbsNode ✓
* OneMinusNode ✓
* CosNode ✓
* SinNode ✓
* LerpNode ✓
* TimeNode ✓
* New Nodes with API

Features:
---------
* Saving project
* Loading project
* Creating Empty project
* Starting execution
* Stopping execution

Technical details:
------------------
The UI is entirely written in Swing

The program execution is run on a separate thread to not block the UI thread. This is achieved by using a SwingWorker.

Saving and loading project is done by Java Serialization. 

## How to use

The project can be opened in IntelliJ Idea and supports Java 7

License
-------

Copyright &copy; 2016 **David Komorowicz**

This program is free software: you can redistribute it and/or modify it under
the terms of the GNU General Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your option) any later
version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with
this program, most likely a file in the root directory, called 'LICENSE'.
If not, see <http://www.gnu.org/licenses>.


<!-- -->

[1]: https://img.shields.io/badge/license-GNU_General_Public_License_v3.0-blue.svg
[2]: http://www.gnu.org/licenses/gpl.html
