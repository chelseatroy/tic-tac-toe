class TicTacToe

	def initialize
		#board
		@board = [[0,0,0],[0,0,0],[0,0,0]]
		@location_hash = { "top left"    => @board[0][0], "top middle"    => @board[0][1], "top right"    => @board[0][2],
						   "left middle" => @board[1][0], "middle"        => @board[1][1], "right middle" => @board[1][2],
						   "bottom left" => @board[2][0], "bottom middle" => @board[2][1], "bottom right" => @board[2][2]}
		#players
		@player_1 = 1
		@player_2 = 2
		#game mechanics
		@has_the_game_ended = 0
		gameplay
	end#initialize

	def gameplay
		instructions
		print_board
		while @has_the_game_ended == 0
			if @has_the_game_ended == 0
				turn(@player_1)
				print_board
				check_win(@player_1)
			end #if player 1
			if @has_the_game_ended == 0
				turn(@player_2)
				print_board
				check_win(@player_2)
			end#if player 2
		end #while game continues
	end #gameplay

	def print_board
		@board[0][0] = @location_hash["top left"]; @board[0][1] = @location_hash["top middle"]; @board[0][2] = @location_hash["top right"]
		@board[1][0] = @location_hash["left middle"]; @board[1][1] = @location_hash["middle"]; @board[1][2] = @location_hash["right middle"]
		@board[2][0] = @location_hash["bottom left"]; @board[2][1] = @location_hash["bottom middle"]; @board[2][2] = @location_hash["bottom right"]

		puts @board[0].inspect
		puts @board[1].inspect
		puts @board[2].inspect
	end#print_board

	def instructions
		puts ""
		puts "Welcome to Tic Tac Toe!"
		puts "Players go turn by turn, using the following commands:"
		puts "top left, top middle, top right, left middle, middle, right middle,"
		puts "bottom left, bottom middle, bottom right."
		puts "First one to get 3 in a row wins!"
	end#instructions

    def check_win(player)
		if @board[0][0] == player && @board[0][1] == player && @board[0][2] == player ||
			@board[1][0] == player && @board[1][1] == player && @board[1][2] == player ||
			@board[2][0] == player && @board[2][1] == player && @board[2][2] == player ||
			@board[0][0] == player && @board[1][1] == player && @board[2][2] == player ||
			@board[0][2] == player && @board[1][1] == player && @board[2][0] == player ||
			@board[0][0] == player && @board[1][0] == player && @board[2][0] == player ||
			@board[0][1] == player && @board[1][1] == player && @board[2][1] == player ||
			@board[0][2] == player && @board[1][2] == player && @board[2][2] == player
			@has_the_game_ended = 1
			puts "player " + player.to_s + " wins!"
		end
	end #check_win

	def turn (player)
		puts "player " + player.to_s + ", it's your turn"
		x = gets.chomp
			if @location_hash[x].nil?
				puts "Please use an acceptable location command."
				turn (player)
			elsif @location_hash[x] != 0
				puts "Please play where the other player hasn't already played."
				turn (player)
			else
				@location_hash[x] = player
			end
	end#turn

end#TicTacToe

game = TicTacToe.new