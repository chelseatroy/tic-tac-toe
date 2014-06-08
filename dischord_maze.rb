require 'tuvi'

step "start" do 
	say "Mwahahahahaha. Welcome to the maze, Twilight. Here are the rules: you have to find all three of your friends and get out of the maze before time runs out."
	code do
    	$moves = 10
    	puts "You have #{$moves} moves remaining."
    end
	response "straight" => "applejack"
	response "left" => "rarity"
	response "right" => "maze"
end

step "applejack" do
	say "congratulations! You found applejack! Where to next?"
	code do
    	$moves -= 1
    	puts "You have #{$moves} moves remaining."
    end
	response "straight" => "maze"
	response "left" => "maze"
	response "right" => "maze"
end

step "maze" do
	say "Whoops, nothing here. Where should we go next?"
	code do
    	$moves -= 1
    	puts "You have #{$moves} moves remaining."
    end
	response "straight" => "rarity"
	response "left" => "rarity"
	response "right" => "maze"
end

step "rarity" do
	say "congratulations! You found rarity! Where to next?"
	code do
    	$moves -= 1
    	puts "You have #{$moves} moves remaining."
    end
	response "straight" => "another_maze"
	response "left" => "another_maze"
	response "right" => "another_maze"
end

step "another_maze" do
	say "Whoops, nothing here. Where should we go next?"
	code do
    	$moves -= 1
    	puts "You have #{$moves} moves remaining."
    end
	response "straight" => "pinkie_pie"
	response "left" => "pinkie_pie"
	response "right" => "another_maze"
end

step "pinkie_pie" do
	say "congratulations! You found Pinkie Pie! You have all your friends. Now you need to get out of the maze before time runs out! Where to next?"
	code do
    	$moves -= 1
    	puts "You have #{$moves} moves remaining."
    end
	response "straight" => "exit"
	response "left" => "exit"
	response "right" => "a_third_maze"
end

step "a_third_maze" do
	say "Whoops, nothing here. Where should we go next?"
	code do
    	$moves -= 1
    	puts "You have #{$moves} moves remaining."
    end
	response "straight" => "exit"
	response "left" => "exit"
	response "right" => "exit"
end

step "exit" do
 say "Congratulations! You made it!"
end



