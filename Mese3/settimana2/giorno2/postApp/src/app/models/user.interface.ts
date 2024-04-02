export interface User {
    imgLink: string;
    id: number,
    name: string,
    email: string,
    role: 'admin'|'user'
}
