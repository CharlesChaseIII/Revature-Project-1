import { Todo } from "./todo.model";

const TODO_FILTERS: any = {

	All: () => true,
	Active: (todo: Todo) => !todo.completed,
	COMPLETED: (todo: Todo) => todo.completed
}

export { TODO_FILTERS }