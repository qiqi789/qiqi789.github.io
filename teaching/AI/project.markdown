---
layout: post
title: 人工智能课程项目---智能的Pacman
---


### 项目介绍

该项目的基础是一个开源的项目，其用Scala实现了Pacman游戏，你可以用一种特定的简单的语言命令pacman的行为。
项目的要求是这样：

 1. 用现有的特定语言制定pacman的智能行为
 2. 分析代码，定义能够为pacman提升智能的新的行为语言指令
 3. 实现比现有更为复杂的人工智能算法
 
 项目可以由个人或小组来完成，小组的人数最多为2人。项目的成果在最后有一个课堂展示过程。本项目虽为选做，但是以上的每一步值10分，做到一步可以为期末考试加上10分。

### 安装和运行步骤

1. 下载并解压[项目源代码(my-Pacman.zip)](my-Pacman.zip)
2. 下载并安装Scala [SBT](http://www.scala-sbt.org/download.html)编译运行工具
3. 下载并解压(基于Eclipse的)[Scala-IDE（开发工具）](http://scala-ide.org/download/sdk.html)
4. 打开Windows PowerShell,并键入在步骤1里解压的项目目录，键入

		 ./activator
		
    （这一步可能需等待库的下载，所下载库都被放入目录：你的用户名/.ivy目录里）
		
5. 然后键入compile进行编译，或直接运行 run 命令，并选择第一个选项运行Pacman程序
6. 在当前命令行里可以键入eclipse命令，建立eclipse可导入的项目
7. 运行步骤3里下载并解压的Scala-IDE，并导入my-Pacman项目，进行编辑，运行时再重复步骤4和5即可。

### 已定义的Pacman的特定行为语言
以下特定行为语言已在程序中定义（具体可参考源代码）：

		move           //  随机移动         
		stay           //  静止
		suchThat,to    //  对返回方向进行过滤
		otherwise,else //  条件否则
		if,when        //  条件如果
		ifHunter       //  如果吃了樱桃处在超级模式
		ifHunted       //  如果在被妖怪追逐过程中
		ifMonstersClose  //  如果妖怪靠近
		ifMonstersFar    //  如果妖怪距离还远
		distanceToCherry   //  返回到樱桃的距离
		distanceToPoint    //  返回到点的距离
		distanceToMonster  //  返回到妖怪的距离
		right,left,up,down  // 分别向右，左，上，下移动
		cornerUpLeft,cornerUpRight,cornerDownRight,cornDownLeft  // 分别向左上角，右上，右下，坐下方向移动
		toAMonster          //  向一个妖怪移动
		farFromMonsters     //  远离妖怪移动
		toAPoint            //  移向一个点
		farFromPoints       //  远离点移动
		toACherry           //  移向一个樱桃
		farFromCherries     //  远离樱桃移动
		inSecurityFor(n)    //  返回在n步内安全的方向

